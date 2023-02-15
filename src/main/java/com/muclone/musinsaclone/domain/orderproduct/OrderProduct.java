package com.muclone.musinsaclone.domain.orderproduct;

import java.util.Objects;

import com.muclone.musinsaclone.domain.AuditingFields;
import com.muclone.musinsaclone.domain.order.Order;
import com.muclone.musinsaclone.domain.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "order_product")
@Entity
public class OrderProduct extends AuditingFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "order_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;

	@JoinColumn(name = "product_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Product product;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof OrderProduct that))
			return false;
		return this.getId() != null && this.getId().equals(that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getId());
	}
}
