package by.model;


import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

/**
 * Created by Роман on 12.07.2017.
 */
@Entity
public class ImageDownloadExample {
    @Id
    @Column(name = "id_image")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    @Basic
    @Column(name = "file")
    @Lob
   private MultipartFile file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageDownloadExample that = (ImageDownloadExample) o;

        if (id != that.id) return false;
        return file != null ? file.equals(that.file) : that.file == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (file != null ? file.hashCode() : 0);
        return result;
    }
}
