package lluna.blog.db.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "post_like")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostLike {

    @Id
    @Column(name="post_like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

}
