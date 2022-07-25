package uz.pdp.cinemaapplication.entity.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
@PackagePrivate
@EntityListeners(AuditingEntityListener.class)
public abstract class AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OrderBy
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    Timestamp createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    Timestamp updatedAt;

    @CreatedBy
    @Column(name = "created_by_id")
    Integer createdBy;

    @LastModifiedBy
    @Column(name = "updated_by_id")
    Integer updatedBy;

}
