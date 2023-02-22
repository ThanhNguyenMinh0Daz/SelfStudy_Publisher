package com.publisher.modules.employeeAndAccount.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "right")
public class Right {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rightId", nullable = false)
    private Integer rightId;
    
    @Column(name = "rightName", nullable = false, length = 45)
    private String rightName;
    
    @Column(name = "rightDesc", nullable = true, length = -1)
    private String rightDesc;

    @OneToMany(mappedBy = "right")
    private List<RoleRightList> roleRightList;
}
