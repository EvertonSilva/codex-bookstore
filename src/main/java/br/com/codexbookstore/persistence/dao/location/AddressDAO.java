package br.com.codexbookstore.persistence.dao.location;

import br.com.codexbookstore.domain.Entity;
import br.com.codexbookstore.domain.location.Address;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO extends AbstractDAO {


    @Override
    public boolean create(Entity entity) {
        return false;
    }

    @Override
    public List<Entity> retrieve(String queryModifiers) {
        openConnection();

        List<Entity> addressList = new ArrayList<>();
        StringBuilder q = new StringBuilder();
        q.append("SELECT * FROM addresses");

        try {
            ResultSet rs = null;
            PreparedStatement stmt = conn.prepareStatement(q.toString());
            rs = stmt.executeQuery();

            while(rs.next()) {
                Address address = new Address();

                address.setId(rs.getLong("addresses.id"));
                address.setAlias(rs.getString("addresses.alias"));
                address.setDistrict(rs.getString("addresses.district"));
                address.setNumber(rs.getString("addresses.number"));
                address.setPostalCode(rs.getString("addresses.postal_code"));

                addressList.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Entity entity) {
        return false;
    }

    @Override
    public boolean delete(Entity entity) {
        return false;
    }
}
