package guru.springfamework.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Customer
{
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long  id;
    private String fname;
    private String lname;

    @Builder
    public Customer(Long id, String fname, String lname)
    {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }
}
