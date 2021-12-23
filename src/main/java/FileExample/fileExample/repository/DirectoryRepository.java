package FileExample.fileExample.repository;

import FileExample.fileExample.entity.DirectoryEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends JpaRepository<DirectoryEntities, String> {
}
