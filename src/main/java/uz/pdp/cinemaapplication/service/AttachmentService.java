package uz.pdp.cinemaapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.cinemaapplication.entity.Attachment;
import uz.pdp.cinemaapplication.repository.AttachmentRepository;

import java.util.List;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;


    public List<Attachment> getAllAttachments() {
        List<Attachment> attachments = attachmentRepository.findAll();
        return attachments;
    }

    public Attachment addAttachment(MultipartFile file) {
        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        attachmentRepository.save(attachment);
        return attachment;
    }

    public Attachment editAttachment(Attachment editingAttachment, MultipartFile file) {
       editingAttachment.setName(file.getOriginalFilename());
       editingAttachment.setSize(file.getSize());
       editingAttachment.setContentType(file.getContentType());
       attachmentRepository.save(editingAttachment);
       return editingAttachment;
    }

}
