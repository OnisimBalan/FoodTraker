package repository;

import models.UserModel;
import repository.base.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository extends BaseRepository {
    public UserModel GetSingleUser(int Id) {
        try {
            ResultSet rs = mConnection.ExecuteSimpleQuery(String.format("SELECT * FROM customer WHERE id=%d", Id));
            if (rs.next()) {
                UserModel user = new UserModel();

                user.Id = Id;
                user.FirstName = rs.getString("nume");
                user.LastName = rs.getString("prenume");
                user.Email = rs.getString("email");
                user.Address = rs.getString("adresa");
                user.PhoneNumber = rs.getString("telefon");

                return user;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public UserModel FindUserByEmailAndPassword(String Email, String HashedPassword) {
        try {
            PreparedStatement ps = mConnection.NewPreparedStatement("SELECT * FROM customer WHERE email=? AND parola=?");

            ps.setString(1, Email);
            ps.setString(2, HashedPassword);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserModel user = new UserModel();

                user.Id = rs.getInt("id");
                user.FirstName = rs.getString("nume");
                user.LastName = rs.getString("prenume");
                user.Email = rs.getString("email");
                user.Address = rs.getString("adresa");
                user.PhoneNumber = rs.getString("telefon");

                return user;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public boolean CreateUser(String HashedPassword, UserModel Data) {
        try {
            PreparedStatement ps = mConnection.NewPreparedStatement("INSERT INTO customer(nume, prenume, email, parola, adresa, telefon)" +
                    "VALUES(?,?,?,?,?,?)");

            ps.setString(1, Data.FirstName);
            ps.setString(2, Data.LastName);
            ps.setString(3, Data.Email);
            ps.setString(4, HashedPassword);
            ps.setString(5, Data.Address);
            ps.setString(6, Data.PhoneNumber);

            return 0 < ps.executeUpdate();
        } catch (SQLException e) {
        }

        return false;
    }
}
