package io.springak4ra.pali_names_api;

import javax.persistence.*;

@Entity
public class PaliName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String paliName;
    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaliName() {
        return paliName;
    }

    public void setPaliName(String paliName) {
        this.paliName = paliName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "PaliName{" +
                ", paliName='" + paliName + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
