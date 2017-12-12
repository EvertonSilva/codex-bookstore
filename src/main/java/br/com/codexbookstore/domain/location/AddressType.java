package br.com.codexbookstore.domain.location;

import br.com.codexbookstore.domain.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "address_types")
public class AddressType extends DomainEntity {
    @Column
    private String name;

    @Column
    @ManyToMany(mappedBy = "addressTypes")
    private List<Address> addressList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
