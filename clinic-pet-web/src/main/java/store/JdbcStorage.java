package store;

import PetClinic.Pet;
import models.User;
import service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JdbcStorage implements Storage {
    private final Connection connection;

    public JdbcStorage(){
        final Settings settings = Settings.getINSTANCE();
        try {
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"),settings.value("jdbc.username"),settings.value("jdbc.password"));
        } catch (SQLException e){
            throw new IllegalStateException(e);
        }
    }

    /**
     * Create a list of users from PostgreSQL
     * @return A list of users
     */
    @Override
    public Collection<User> values() {
        final List<User> users = new ArrayList<>();
        try (final Statement statement = this.connection.createStatement();
             final ResultSet rs = statement.executeQuery("select * from client")) {
            while (rs.next()){
                users.add(new User(rs.getInt("uid"),
                        rs.getString("name"),
                        rs.getString("email"),
                        getPet(rs.getInt("uid")),
                        rs.getString("phone"),
                        rs.getString("sex"),
                        rs.getString("city"),
                        rs.getString("agree")));
            }
        } catch (SQLException e){
            throw new IllegalStateException(e);
        }
        return users;
    }

    /**
     * Return Pet class by user's ID
     * @param client_id user's ID
     * @return Pet class
     */
    private Pet getPet(int client_id){
        Pet pet = null;
        try (final Statement statement = this.connection.createStatement();

             final ResultSet rs = statement.executeQuery("select * from pet as pet where client_id = ("+client_id+")")) {
            while (rs.next()){
                pet = new Pet(rs.getString("nick"),rs.getString("type"));
            }
        } catch (SQLException e){
            throw new IllegalStateException(e);
        }

        return pet;
    }

    /**
     * Add user and pet to table in PostgreSQL
     * @param user user to be add
     */
    @Override
    public void add(User user) {
       try ( final PreparedStatement statement = this.connection.prepareStatement("insert into client (name, phone, city, sex, email, agree) values (?,?,?,?,?,?) returning uid;");
         PreparedStatement statementPet = this.connection.prepareStatement("insert into pet (client_id, nick, type ) values (?,?,?);")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPhone());
            statement.setString(3, user.getCity());
            statement.setString(4, user.getSex());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getAgree());
            statement.executeQuery();
            ResultSet rs = statement.getResultSet();
            rs.next();
            int a = Integer.parseInt(rs.getString(1));
            statementPet.setInt(1, a);
            statementPet.setString(2, user.getPet().getName());
            statementPet.setString(3, user.getPet().getType());
            statementPet.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new IllegalStateException("Could not create new user!");
        }

    }

    /**
     * Edit user in table PostgreSQL
     * @param user user to be edit
     */
    @Override
    public void edit(User user) {

    }

    /**
     * Delete user and pet by ID from PostgreQSL DB
     * @param id id's users to be delete
     */
    @Override
    public void delete(int id) {
        try ( PreparedStatement statementPet = this.connection.prepareStatement("delete from pet as pet where client_id = '"+id+"'");
                PreparedStatement statement = this.connection.prepareStatement("delete from client as client where client.uid = '"+id+"'")){
            statementPet.executeUpdate();
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Get user from PostgreSQL by id
     * @param id user's id
     * @return User class
     */
    @Override
    public User get(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from client as client where client.uid = '"+id+"'");
        final ResultSet rs = statement.executeQuery()){
                return new User(rs.getInt("uid"),
                        rs.getString("name"),
                        rs.getString("email"),
                        getPet(rs.getInt("uid")),
                        rs.getString("phone"),
                        rs.getString("sex"),
                        rs.getString("city"),
                        rs.getString("agree"));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get user by login from PostgreSQL
     * @param login user's name for search
     * @return User class
     */
    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
        try {
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
