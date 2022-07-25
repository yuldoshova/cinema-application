package uz.pdp.cinemaapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.cinemaapplication.entity.Attachment;
import uz.pdp.cinemaapplication.entity.AttachmentContent;

@Repository
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {

 AttachmentContent  findAttachmentContentByAttachmentId(Integer attachmentId);

}
