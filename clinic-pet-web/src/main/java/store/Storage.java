package store;

import models.User;

import java.util.Collection;

/**
 * @author JS
 * @since 14.09.2018
 */

public interface Storage {

    public Collection<User> values();

    public void add(final User user);

    public void edit(final User user);

    public void delete(final int id);

    public User get(final int id);

    public User findByLogin(final String login);

    public int generateId();

    public void close();
}
