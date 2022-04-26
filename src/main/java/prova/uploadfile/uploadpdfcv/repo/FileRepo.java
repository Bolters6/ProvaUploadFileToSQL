package prova.uploadfile.uploadpdfcv.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import prova.uploadfile.uploadpdfcv.models.File;


public interface FileRepo extends JpaRepository<File, Long> {

}
