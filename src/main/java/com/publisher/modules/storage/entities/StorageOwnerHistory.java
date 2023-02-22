package com.publisher.modules.storage.entities;

import com.publisher.modules.employeeAndAccount.entities.Employee;
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
@Table(name = "storage_owner_history")
public class StorageOwnerHistory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "historyId", nullable = false)
    private Integer historyId;

    @ManyToOne
    @JoinColumn(name = "storageId", referencedColumnName = "storageId")
    private Storage storage;
    @Column(name = "storageId", nullable = false, insertable = false, updatable = false)
    private Integer storageId;

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;
    @Column(name = "employeeId", nullable = false, insertable = false, updatable = false)
    private Integer employeeId;

    @Column(name = "ownerFrom", nullable = false)
    private Timestamp ownerFrom;
    
    @Column(name = "ownerTo", nullable = true)
    private Timestamp ownerTo;

}
