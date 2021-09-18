package uz.pdp.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "director_name",nullable = false)
    private String directorName;

    @Column(name = "corp_number",nullable = false)
    private String corpNumber;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
