package fr.formation.jsontypicodephotos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Photo {
    private int id;
    private int albumId;
    private String title;
    private String url;
    private String thumbnailUrl;
}
