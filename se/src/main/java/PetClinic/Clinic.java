package PetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    /**
     * Список клиентов
     */
    private  final Client[] clients;

    public Clinic(final int size) {
        this.clients = new Client[size];
    }

    /**
     * Добавить клиента.
     * @param position Позиция
     * @param client Клиент
     */
    public void addClient (final int position, final Client client) {
        this.clients[position] = client;
    }


    /**
     * Поиск клиента по имени питомца
     * @param name Имя питомца
     * @return список клиентов у которых имя питомце = name
     */
    public Client[] findClientsByPetName(final String name)  {
        List<Client> list = new ArrayList<Client>();

        for (Client client : clients) {
            if (client.getPet().getClass().equals(name)){
                list.add(client);
            }
        }
        Client[] clients1 = list.toArray(new Client[list.size()]);

        return clients1;
    }

    /**
     * Поиск клиентов по имени
     * @param name имя клиента
     * @return массив клиентов с именем name
     */

    public Client[] findClientsByName(final String name) {
        List<Client> list = new ArrayList<Client>();

        for (Client client : clients) {
            if (client.getId().equals(name)){
                list.add(client);
            }
        }
        Client[] clients1 = list.toArray(new Client[list.size()]);

        return clients1;
    }

    /**
     * Удаляем клиента из Массива
     * @param client клиент которого удаляем
     */

    public  void removeClient(Client client){
        for (Client client1 : clients) {
            if (client1.equals(client))
                client1 = null;
        }
    }


    public void removePet(Client client){
        for (Client client1 : clients) {
            if (client1.equals(client)){
                client1.setPet(null);
            }
        }
    }
}
