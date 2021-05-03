package com.example._library_management._library_management.data;

import lombok.*;
import javax.persistence.Entity;

public enum TransactionStatus {
    SUCCESSFUL,
    FAILED,
    PENDING
}
