[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=8262621&assignment_repo_type=AssignmentRepo)
# Maze Solver - Solucionador de Labirintos

Você deve implementar, em Java, um "solucionador de labirintos", baseado  no algoritmo DFS, estudado nas últimas aulas e, com as seguintes especificações:

## Requisitos

* Você pode usar a implementação recursiva ou iterativa.
* Você deve usar a classe Main e o importador de arquivos fornecidos neste repositório.
* Seu código será testado conforme as entradas e saídas a seguir, então ele **deve obrigatóriamente** atender a esse padrão.

### Entradas e saídas esperadas:

Seu programa irá receber, da *entrada padrão*, um labirinto em formato texto, conforme a seguinte especificação:
uma linha com o tamanho (por exemplo 5, para indicar um labirinto 5x5) e as próximas 5 linhas representando o labirinto.

```
5
1 1 1 1 1
1 2 0 1 1
1 1 0 1 1
1 1 0 0 0
1 1 1 1 3
```

No labirinto, o número `1` representa uma *parede*; `2` representa a *entrada*; `3` representa a *saída*; `0` representa um local em que é possível caminhar

Seu algoritmo deve processar o labirinto e retornar:

```
- - - - -
- 2 S - -
- - S - -
- - S S S
- - - - 3
```

Em que `S` indica o caminho para a solução; `2` a entrada e `3` a saída do labirinto. Todos os outros campos devem estar marcados com `-`.

Caso o labirinto não seja resolvível, você deve retornar: `Não é possível resolver o labirinto.`

## Algoritmo

Após ler o labirinto e convertê-lo em um objeto, você deve processá-lo pelo algoritmo DFS. Primeiro procure a **entrada** (o caracter `2`). Armazene as coordenadas da entrada. A partir daí, você pode fazer com que seu algoritmo busque os campos com o valor `0`. Você pode adotar a seguinte estratégia:

```
Leia o labirinto de entrada
Insira a posição atual na pilha.
Marque a posição como visitada.
Enquanto a posição atual não for a saída
  Tente seguir adiante (para baixo, para direita ou para cima) e atualize a posição atual
  Se for possível, 
    marque a posição atual como visitada
    Insira a posição atual na pilha
  Senão
    retire a posição atual da pilha
    pegue a primeira posição disponível na pilha
  Fim se
 Fim Enquanto
 
 Imprima a solução baseado na pilha de solução.
 ```
