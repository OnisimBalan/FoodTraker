package repository.base;

public class BaseRepository {
    protected final DbConnection mConnection = DbConnection.OpenNewConnection();
}
