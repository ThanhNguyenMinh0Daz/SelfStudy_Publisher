package com.publisher.modules.employeeAndAccount.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role_right_list")
public class RoleRightList {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "pairId", nullable = false)
    private Integer pairId;

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    private Role role;
    @Column(name = "roleId", nullable = false, insertable = false, updatable = false)
    private Integer roleId;

    @ManyToOne
    @JoinColumn(name = "rightId", referencedColumnName = "rightId")
    private Right right;
    @Column(name = "rightId", nullable = false, insertable = false, updatable = false)
    private Integer rightId;
    
    @Column(name = "validFrom", nullable = false)
    private Timestamp validFrom;
    
    @Column(name = "validTo", nullable = true)
    private Timestamp validTo;
}
