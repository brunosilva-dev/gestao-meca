package br.com.brunosilva.gestao_meca.modules.game.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

/**
 * @Entity game
 * @Description: Dentro da entity foi utilizado a dependência do lombok
 */

@Data
@Entity(name = "game")
public class GameEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @Column(columnDefinition = "Text")
  private String briefDescription;

  private String recentAnalysis;
  private BigDecimal countRecentAnalysis;
  private String allReviews;
  private BigDecimal countAllReviews;
  private String releaseDate;
  private String developer;
  private String distributor;

  @Column(columnDefinition = "Text")
  private String tags;

  private String category;
  private BigDecimal price;
  private String image;

  @Column(columnDefinition = "Text")
  private String fullDescription;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @ManyToMany
  @JoinTable(name = "game_category", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
  private Set<CategoryEntity> categories;

}
