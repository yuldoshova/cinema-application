package uz.pdp.cinemaapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import uz.pdp.cinemaapplication.entity.template.AbsEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "attachments")
@PackagePrivate
public class Attachment extends AbsEntity {

      String name;
      Long size;
      String contentType;


    public Attachment(String name, long size, String contentType) {
        this.name = name;
        this.size = size;
        this.contentType = contentType;
    }

}
