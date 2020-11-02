
package com.project.thrifting.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {

    }

    public Role(ERole name) {
        this.name = name;
    }

    public Integer getId() {
        return role_id;
    }

    public void setId(Integer id) {
        this.role_id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
