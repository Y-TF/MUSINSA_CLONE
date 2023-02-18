package com.muclone.musinsaclone.domain.brand;

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
@Table(name = "brand")
@Entity
public class Brand extends AuditingFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_manager_id")
	private UserAccount brandManager;

	@Column(name = "brand_name", nullable = false)
	private String brandName;

	@Column(name = "brand_status", length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private BrandStatus brandStatus;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Brand that))
			return false;
		return this.getId() != null && this.getId().equals(that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getId());
	}
}
