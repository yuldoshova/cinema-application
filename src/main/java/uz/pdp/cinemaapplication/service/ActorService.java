package uz.pdp.cinemaapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.cinemaapplication.entity.Actor;
import uz.pdp.cinemaapplication.entity.Attachment;
import uz.pdp.cinemaapplication.entity.AttachmentContent;
import uz.pdp.cinemaapplication.repository.ActorRepository;
import uz.pdp.cinemaapplication.repository.AttachmentContentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    AttachmentService attachmentService;

    @Autowired
    AttachmentContentService attachmentContentService;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    public List<Actor> getAllActors() {
        List<Actor> actors = actorRepository.findAll();
        return actors;
    }

    public Actor getActorById(Integer id) {
        Optional<Actor> Actor = actorRepository.findById(id);
        if (Actor.isPresent()) {
            return Actor.get();
        }
        return new Actor();
    }


    public boolean saveActor(MultipartFile file, Actor actor) {
        Attachment attachment = attachmentService.addAttachment(file);
        attachmentContentService.addAttachmentContent(file, attachment);
        actor.setActorPhoto(attachment);
        Actor saved = actorRepository.save(actor);
        return saved != null;
    }


    public boolean deleteActor(Integer id) {
        try {
            actorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public Actor editActor(Integer id, Actor actor, MultipartFile file) {
        boolean isExist = actorRepository.existsActorById(id);

        if (!isExist) {
            return null;
        }
        Actor actorById = getActorById(id);
        Attachment editingAttachment = actorById.getActorPhoto();

        Attachment attachment = attachmentService.editAttachment(editingAttachment, file);
        AttachmentContent attachmentContent = attachmentContentRepository.findAttachmentContentByAttachmentId(attachment.getId());
        attachmentContentService.editAttachmentContent(file, attachment, attachmentContent);

        actorById.setFullName(actor.getFullName());
        actorById.setActorPhoto(attachment);
        actorRepository.save(actorById);

        return actorById;
    }


}



