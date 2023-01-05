package pl.nullpointerexception.hibernate.entity;

public class ReviewDto {
    private Long id;
    private String contend;
    private int rating;

    public ReviewDto(Long id, String contend, int rating) {
        this.id = id;
        this.contend = contend;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public String getContend() {
        return contend;
    }

    public int getRating() {
        return rating;
    }
}
