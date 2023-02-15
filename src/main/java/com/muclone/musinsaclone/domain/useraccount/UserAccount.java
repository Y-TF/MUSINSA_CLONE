package com.muclone.musinsaclone.domain.useraccount;

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
@Table(name = "user_account")
@Entity
public class UserAccount extends AuditingFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "login_id", unique = true, length = 50, nullable = false)
	private String loginId;

	@Column(unique = true, length = 50, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(length = 50, nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof UserAccount that))
			return false;
		return this.getId() != null && this.getId().equals(that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getId());
	}
}
