# Sistema-de-Gest-o-Escolar

POST /aluno<br>
json{<br>
    "nome": "João Silva",<br>
    "email": "joao@email.com",<br>
    "matricula": "2024001",<br>
    "data_nascimento": "2000-05-15"<br>
}<br><br>

POST /professor<br>
json{<br>
    "nome": "Maria Souza",<br>
    "email": "maria@email.com",<br>
    "disciplina": "Matemática"<br>
}<br><br>

POST /curso<br>
json{<br>
    "nome": "Engenharia de Software",<br>
    "codigo": "ES2026"<br>
}<br><br>

POST /turma<br>
json{<br>
    "nome": "Turma A",<br>
    "curso_id": 1,<br>
    "professor_id": 1<br>
}<br><br>

POST /aula<br>
json{<br>
    "turma_id": 1,<br>
    "data_hora": "2026-03-10",<br>
    "assunto": "Introdução à Programação"<br>
}<br><br>

POST /nota<br>
json{<br>
    "aluno_id": 1,<br>
    "aula_id": 1,<br>
    "valor": 8.5<br>
}<br><br>
