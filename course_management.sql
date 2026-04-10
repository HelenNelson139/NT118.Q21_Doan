CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    full_name VARCHAR(255),
    role ENUM('admin', 'teacher', 'student') DEFAULT 'student',
    status ENUM('active', 'banned', 'deleted') DEFAULT 'active',
    avatar_url VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT UNIQUE,
    student_code VARCHAR(20),
    date_of_birth DATE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE teachers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT UNIQUE,
    teacher_code VARCHAR(20),
    department VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE admins (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT UNIQUE,
    phone VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE lessons (
    id INT AUTO_INCREMENT PRIMARY KEY,
    teacher_id INT,
    title VARCHAR(255) NOT NULL,
    description_lesson VARCHAR(255) NOT NULL,
    what_you_learn VARCHAR(255) NOT NULL,
    skill_learned VARCHAR(255) NOT NULL,
    thumbnail_url VARCHAR(255) NOT NULL,
    status ENUM('pending', 'approved', 'rejected') DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (teacher_id) REFERENCES teachers(id)
);

CREATE TABLE modules (
    id INT AUTO_INCREMENT PRIMARY KEY,
    lesson_id INT,
    title VARCHAR(255) NOT NULL,
    objective VARCHAR(255) NOT NULL,
    content VARCHAR(255) NOT NULL,
    example VARCHAR(255) NOT NULL,
    image_expamle_url VARCHAR(255),
    order_index INT NOT NULL,
    FOREIGN KEY (lesson_id) REFERENCES lessons(id) ON DELETE CASCADE
);

CREATE TABLE enrollments (
    user_id INT,
    lesson_id INT,
    enrolled_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, lesson_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (lesson_id) REFERENCES lessons(id)
);

CREATE INDEX idx_teacher ON lessons(teacher_id);
CREATE INDEX idx_lesson ON modules(lesson_id);
