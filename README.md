# Motor de Triagem de Alertas NOC

**Integrantes do Grupo:**
* Rodrigo Queiroz Faria Filho - 123119730
* Nycolas Alves da Rocha Thuner - 123115545
* Felipe Lauria Fialho - 1261945833

## 📌 Sobre o Projeto
O sistema é um back-end que recebe alertas de infraestrutura e classifica a severidade deles automaticamente, resolvendo o gargalo de triagem manual.

* **Linguagem:** Java
* **Padrões de Projeto:** Strategy e Factory Method.
* **Princípios Aplicados:** SOLID.
* **Testes:** JUnit 5

## 🛠️ Como Montar no Eclipse
1. Crie um `Java Project` chamado `triagem-alertas`.
2. Crie o pacote `com.noc` dentro de `src`.
3. Adicione as classes do código-fonte (Estrategias, Processador, Alerta).
4. Adicione a biblioteca do JUnit 5 (`Build Path > Add Libraries > JUnit`).
5. Crie a classe de teste `ProcessadorAlertasTest.java`.

## 🚀 Como Executar os Testes
Para provar o funcionamento da regra de negócio:
1. Abra o arquivo `ProcessadorAlertasTest.java` no Eclipse.
2. Clique com o botão direito no código.
3. Vá em `Run As > JUnit Test`.
4. A validação ocorre pela barra verde do JUnit, confirmando que os alertas são classificados corretamente para Crítico, Aviso ou Info.