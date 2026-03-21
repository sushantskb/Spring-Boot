# 📘 JPA & Hibernate: Entity Lifecycle & Transactions

This project serves as a lab for understanding how Spring Data JPA manages entity states and database synchronization.

## (Core Concepts)

### 1. The Persistence Context (1st Level Cache)
The Persistence Context is like a "short-term memory" for JPA. Within a `@Transactional` method:
* Every entity fetched is stored in this context.
* If you ask for the same ID twice, JPA returns the **same object reference**.
* This reduces unnecessary database hits.



### 2. Entity Lifecycle States
| State | Description |
| :--- | :--- |
| **Transient** | New object created (`new Patient()`), not yet associated with a session/DB. |
| **Managed** | Associated with a session. Changes are tracked automatically. |
| **Detached** | The session/transaction is closed. Changes are no longer tracked. |
| **Removed** | Scheduled for deletion from the database. |



### 3. Dirty Checking & @Transactional
One of Hibernate's most powerful features.
* **How it works:** At the end of a transaction, Hibernate compares the current state of a **Managed** entity with its original version (the "snapshot").
* **The Result:** If they differ, Hibernate automatically generates and executes an `UPDATE` statement.
* **Benefit:** You don't need to manually call `repository.save(entity)` for updates inside a transaction.

## 🧪 Experiments Conducted
1. **Reference Equality:** Verified that `p1` and `p2` fetching the same ID point to the same memory address.
2. **Auto-Update:** Verified that changing `p1.setName()` reflected in the database without an explicit save call.

---
*Revision Note: Always ensure the transaction boundary is large enough to cover all related database operations.*