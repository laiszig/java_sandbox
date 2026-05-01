# Coding Dojo

## 🏗️ Estrutura da Sessão (Total: 1h 15min)

* **Coding Randori:** 60 minutos (Prática no teclado).
* **Retrospectiva:** 15 minutos (Discussão final).

---

## 🔄 Dinâmica de Troca de Papéis (Timebox: 5 min)

O rodízio é o coração do Randori. Ele garante que ninguém domine o teclado por muito tempo e que todos participem ativamente.

1.  **Piloto:** É quem está com as "mãos na massa". Sua função é transformar a ideia discutida com o copiloto em código e testes.
2.  **Copiloto:** É o conselheiro imediato. Ajuda o piloto a detectar erros de digitação, sugere nomes de variáveis e pensa no próximo passo lógico.
3.  **Plateia:** Observa em silêncio. Só pode intervir quando o tempo de troca for atingido ou se os testes estiverem passando.

**O Fluxo de Rotação:**
A cada **5 minutos**, o cronômetro toca e ocorre a seguinte dança:
* O **Piloto** sai e volta para a plateia.
* O **Copiloto** assume a cadeira de **Piloto**.
* Um integrante da **Plateia** assume a cadeira de **Copiloto**.

---

## 🧪 Regras Técnicas: Testes Obrigatórios

Embora o TDD (Test-Driven Development) não seja obrigatório (você não precisa escrever o teste *antes* do código), a **entrega da funcionalidade só é válida se acompanhada por testes unitários**.

* **Tecnologias:** Java com **JUnit 5** (asserções) e **Mockito** (para simular dependências, caso necessário).
* **Critério de Aceite:** Nenhuma lógica de negócio (como o cálculo das notas de troco) deve ser considerada "pronta" se não houver um método de teste que valide o cenário de sucesso e os cenários de erro.
* **Foco na Qualidade:** O objetivo dos testes aqui é garantir que o próximo par possa refatorar o código com segurança, sabendo que não quebrou o que já foi construído.

---

## 🚀 Fluxo de Trabalho durante os 60 min

1.  **Entendimento:** O par atual lê o desafio do troco.
2.  **Desenvolvimento:** Codificam a lógica e os testes. O piloto pode escrever a lógica e depois o teste, ou vice-versa, desde que ambos existam.
3.  **Interrupção:** No minuto 5, a troca acontece **exatamente onde o código estiver** (mesmo que no meio de uma frase). O novo par assume o contexto deixado.

---

## 🧐 Retrospectiva (15 min)

Após o encerramento da 1ª hora, todos se reúnem para discutir a experiência:

* **O que funcionou:** A lógica do troco foi fácil de implementar sem a pressão do TDD?
* **Dificuldades:** Como foi lidar com o JUnit e Mockito em um tempo tão curto?
* **Aprendizado:** Alguém utilizou uma técnica de lógica ou algum recurso do Java que os outros não conheciam?
* **Processo:** O tempo de 5 minutos foi suficiente para evoluir o pensamento?