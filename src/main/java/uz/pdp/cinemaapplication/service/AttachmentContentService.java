package uz.pdp.cinemaapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.cinemaapplication.entity.Attachment;
import uz.pdp.cinemaapplication.entity.AttachmentContent;
import uz.pdp.cinemaapplication.repository.AttachmentContentRepository;

import java.io.IOException;
import java.util.List;

@Service
public class AttachmentContentService {

    @Autowired
    AttachmentContentRepository attachmentContentRepository;


    public List<AttachmentContent> getAllAttachmentContents() {
        List<AttachmentContent> attachmentContents = attachmentContentRepository.findAll();
        return attachmentContents;
    }


    public AttachmentContent addAttachmentContent(MultipartFile file, Attachment attachment) {
        AttachmentContent attachmentContent = new AttachmentContent();
        try {
            attachmentContent.setAttachment(attachment);
            attachmentContent.setData(file.getBytes());
            return attachmentContentRepository.save(attachmentContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public AttachmentContent editAttachmentContent(MultipartFile file,
                                                   Attachment attachment,
                                                   AttachmentContent attachmentContent) {
        try {
            attachmentContent.setAttachment(attachment);
            attachmentContent.setData(file.getBytes());
            return attachmentContentRepository.save(attachmentContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}