# 🏦 Sistema Bancário - Projeto Orientado a Objetos

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![Swing](https://img.shields.io/badge/Java_Swing-ED8B00?style=for-the-badge&logo=java&logoColor=white)

Aplicação desktop de simulação bancária desenvolvida em Java. O sistema permite o gerenciamento completo de contas bancárias, incluindo operações de depósito, saque (com regras de taxas por tipo de conta), transferências via PIX, extrato detalhado e simulação de empréstimos.

---

## 🚀 Funcionalidades

- **Autenticação e Cadastro:** Login seguro e criação de novas contas (Corrente ou Poupança).
- **Operações Financeiras:**
  - Depósitos.
  - Saques (com aplicação de taxas específicas dependendo do tipo da conta).
  - Transferências via PIX (validação de saldo e destinatário).
- **Extrato:** Histórico detalhado de transações organizadas por data e hora.
- **Empréstimos:** Simulador de parcelamento e contratação de crédito instantâneo.

---

## 🏛️ Arquitetura e Organização (MVC)

O projeto foi estruturado seguindo o padrão de projeto **MVC (Model-View-Controller)**, garantindo a separação clara de responsabilidades:

```text
📦 Source Packages
 ┣ 📂 com.mycompany.projeto.bancario.Controller  # Regras de negócio e intermediação
 ┃ ┣ 📄 Cadastro.java
 ┃ ┣ 📄 Deposito.java
 ┃ ┣ 📄 Emprestimo.java
 ┃ ┣ 📄 Extrato.java
 ┃ ┣ 📄 Saque.java
 ┃ ┗ 📄 Transferencia.java
 ┣ 📂 com.mycompany.projeto.bancario.Icones      # Recursos visuais e imagens da UI
 ┣ 📂 com.mycompany.projeto.bancario.Model       # Classes de negócio e entidades (POO pura)
 ┃ ┣ 📄 Cliente.java
 ┃ ┣ 📄 Conta.java
 ┃ ┣ 📄 ContaCorrente.java
 ┃ ┣ 📄 ContaPoupanca.java
 ┃ ┗ 📄 Main.java
 ┣ 📂 com.mycompany.projeto.bancario.Utils       # Ferramentas e comunicação externa
 ┃ ┣ 📄 bancodedados.sql
 ┃ ┗ 📄 conexao.java
 ┗ 📂 com.mycompany.projeto.bancario.View        # Interfaces Gráficas (Java Swing)
   ┣ 📄 TelaCadastro.java
   ┣ 📄 TelaDeposito.java
   ┣ 📄 TelaExtrato.java
   ┣ 📄 TelaLogin.java
   ┣ 📄 TelaPix.java
   ┣ 📄 TelaPrincipal.java
   ┗ 📄 TelaSaque.java
```

---

## 🧠 Conceitos de POO e Princípios SOLID Aplicados

O sistema foi rigorosamente desenhado para atender aos fundamentos da Programação Orientada a Objetos e boas práticas de engenharia de software:

### Fundamentos POO:
- **Classes e Objetos:** Modelagem do domínio bancário (`Cliente`, `Conta`, etc.).
- **Encapsulamento:** Proteção do estado dos objetos com atributos `private`/`protected` e acesso via métodos `get/set`.
- **Herança:** Especialização de contas através de `ContaCorrente` e `ContaPoupanca` estendendo a classe mãe `Conta`.
- **Associação/Agregação:** A classe `Conta` possui uma instância de `Cliente` (`titular`), demonstrando o relacionamento "tem um".
- **Sobrescrita de Métodos:** Utilização da anotação `@Override` para definir regras específicas de cobrança nas classes filhas.
- **Polimorfismo:** Controllers operando dinamicamente sobre a superclasse genérica `Conta`, executando comportamentos diferentes de acordo com a instância real em tempo de execução.

### Princípios SOLID:
- **SRP (Single Responsibility Principle):** Separação estrita onde a `View` apenas desenha a interface, o `Model` guarda a estrutura de dados e o `Controller` gerencia a lógica e o acesso ao banco.
- **OCP (Open/Closed Principle):** O sistema permite a adição de novos tipos de conta (ex: Conta Salário) através de herança e extensão da classe `Conta`, sem necessidade de modificar a lógica base existente.
- **LSP (Liskov Substitution Principle):** Os métodos do sistema (como saques) podem receber qualquer objeto derivado de `Conta` garantindo que o programa continue funcionando de forma íntegra.

---

## 🎓 Contexto Acadêmico

Este projeto foi desenvolvido como requisito avaliativo da disciplina de **Programação Orientada a Objetos (POO)** do **3º Semestre** do curso de **Engenharia de Software**.

📍 **Instituição:** Instituto Federal do Ceará (IFCE) - Campus Acopiara  
👨‍🏫 **Professor Orientador:** Me. Vinícius Nunes Barbosa  

### 👨‍💻 Desenvolvido por:
- Ney Adrian Casimiro Oliveira
- Alex Silva de Almeida
- Yuri Carlos Alves
- Isaque Almeida Holanda
- Ronald Quaresma Duarte

---
*Projeto acadêmico construído para fins educacionais.*
