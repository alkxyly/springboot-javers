CREATE TABLE TB_PMS_PERMISSAO(PMS_NRID BIGINT AUTO_INCREMENT PRIMARY KEY, PMS_NMPERMISSAO VARCHAR(255) NOT NULL, PMS_DSPERMISSAO VARCHAR(255) NOT NULL);

CREATE TABLE jv_commit (
    commit_pk BIGINT NOT NULL AUTO_INCREMENT,
    author VARCHAR(200),
    commit_date TIMESTAMP,
    commit_date_instant CHARACTER VARYING(30),
    commit_id DECIMAL(20,0),
    PRIMARY KEY (commit_pk)
);

CREATE TABLE jv_commit_property (
    commit_fk BIGINT NOT NULL,
    property_name VARCHAR(100),
    property_value VARCHAR(4000)
);

ALTER TABLE jv_commit_property ADD FOREIGN KEY (commit_fk) REFERENCES jv_commit(commit_pk);

CREATE TABLE jv_global_id (
    global_id_pk BIGINT NOT NULL AUTO_INCREMENT,
    local_id VARCHAR(200),
    fragment VARCHAR(200),
    owner_id_fk BIGINT,
    type VARCHAR(200),
    PRIMARY KEY (global_id_pk)
);

CREATE TABLE jv_snapshot (
    snapshot_pk BIGINT NOT NULL AUTO_INCREMENT,
    version BIGINT,
    state VARCHAR(4000),
    changed_properties VARCHAR(4000),
    TYPE_NAME VARCHAR(20),
    managed_type VARCHAR(200),
    global_id_fk BIGINT NOT NULL,
    commit_fk BIGINT NOT NULL,
    primary_key VARCHAR(200),
    commit_date TIMESTAMP,
    commit_author VARCHAR(200),
    PRIMARY KEY (snapshot_pk)
);

ALTER TABLE jv_snapshot ADD FOREIGN KEY (global_id_fk) REFERENCES jv_global_id(global_id_pk);
ALTER TABLE jv_snapshot ADD FOREIGN KEY (commit_fk) REFERENCES jv_commit(commit_pk);