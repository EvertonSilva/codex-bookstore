package br.com.codexbookstore.persistence.dao.location;

import br.com.codexbookstore.domain.DomainEntity;
import br.com.codexbookstore.domain.location.Address;
import br.com.codexbookstore.persistence.dao.AbstractDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO extends AbstractDAO {


    @Override
    public boolean create(DomainEntity domainEntity) {
        return false;
    }

    @Override
    public List<DomainEntity> retrieve(String queryModifiers) {
//        openConnection();
//
//        List<DomainEntity> addressList = new ArrayList<>();
//        StringBuilder q = new StringBuilder();
//        q.append("SELECT * FROM addresses");
//
//        try {
//            ResultSet rs = null;
//            PreparedStatement stmt = conn.prepareStatement(q.toString());
//            rs = stmt.executeQuery();
//
//            while(rs.next()) {
//                Address address = new Address();
//
//                address.setId(rs.getLong("addresses.id"));
//                address.setAlias(rs.getString("addresses.alias"));
//                address.setDistrict(rs.getString("addresses.district"));
//                address.setNumber(rs.getString("addresses.number"));
//                address.setPostalCode(rs.getString("addresses.postal_code"));
//
//                addressList.add(address);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public boolean update(DomainEntity domainEntity) {
        return false;
    }

    @Override
    public boolean delete(DomainEntity domainEntity) {
        return false;
    }
}
