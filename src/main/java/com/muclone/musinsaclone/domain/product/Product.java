package com.muclone.musinsaclone.domain.product;

import java.util.Objects;

import com.muclone.musinsaclone.domain.AuditingFields;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product")
@Entity
public class Product extends AuditingFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "product_category", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private ProductCategory productCategory;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Product that))
			return false;
		return this.getId() != null && this.getId().equals(that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getId());
	}
}
