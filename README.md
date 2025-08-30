# 📚 Sistema de Gerenciamento Matricial (SGM)

O **Sistema de Gerenciamento Matricial (SGM)** é uma aplicação em **Java** desenvolvida para auxiliar na **criação e gerenciamento de matrizes curriculares** em cursos de graduação.  

O sistema foi construído utilizando **Hibernate ORM** para persistência de dados e **PostgreSQL** como banco relacional.  

---

## 🚀 Funcionalidades

O sistema permite:  
- 📌 **Cadastrar Curso**  
- 📌 **Cadastrar Disciplina**  
- 📌 **Cadastrar Semestre**  
- 📌 **Vincular Disciplina a Semestre**  
- 📌 **Consultar Cursos**  
- 📌 **Consultar Disciplinas**  
- 📌 **Consultar Disciplinas por Semestre**  
- 📌 **Consultar carga horária por semestre**  
- 📌 **Consultar carga horária teórica ou prática**  

---

## 🗂️ Estrutura dos Dados

### Curso
- `id`  
- `descricao`

### Semestre
- `id`  
- `numero`  
- `descricao`

### Disciplina
- `id`  
- `codigo`  
- `nome`  
- `nucleo`  
- `chats_pratica` | `chats_teorica` | `chats_distancia`  
- `chts_pratica` | `chts_teorica` | `chts_distancia`

### Vínculo
- `id`  
- `idCurso`  
- `idSemestre`  
- `idDisciplina`  

---

## 🛠️ Tecnologias Utilizadas
- **Java 17** (ou a versão que você usou)  
- **Hibernate ORM 6.3.0.Final**  
- **PostgreSQL 42.6.0**  
- **Maven** para gerenciamento de dependências  

---

## ⚡ Como Executar o Projeto

1. Clone o repositório:
```bash
git clone https://github.com/Brettas2602/Sistema-de-Gerenciamento-Matricial.git
cd Sistema-de-Gerenciamento-Matricial
````

2. Configure o banco de dados PostgreSQL.
   Crie um banco com o nome desejado e ajuste o arquivo `hibernate.cfg.xml` com suas credenciais:

```xml
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/sgm</property>
<property name="hibernate.connection.username">seu_usuario</property>
<property name="hibernate.connection.password">sua_senha</property>
```

3. Compile e execute o projeto com Maven:

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.seuprojeto.Main"
```

---
