package com.muclone.musinsaclone.domain.order;

import java.util.Objects;

import com.muclone.musinsaclone.domain.AuditingFields;
import com.muclone.musinsaclone.domain.useraccount.UserAccount;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "orders")
@Entity
public class Order extends AuditingFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "user_account_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private UserAccount userAccount;

	@Column(name = "order_status", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Order that))
			return false;
		return this.getId() != null && this.getId().equals(that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getId());
	}
}
