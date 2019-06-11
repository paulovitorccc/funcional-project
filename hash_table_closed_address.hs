import qualified Data.Map as Map

-- Retorna se a tabela interna está fazia.
isEmpty t = undefined

-- Ele retorna o tamanho da tabela 
-- interna dessa tabela de hash.
capacity t = undefined

-- Retorna quantos valores foram inseridos na tabela hash.
size t = undefined

-- Insere um objeto não nulo na tabela de hash. O hashtable não trabalha 
-- com elementos duplicados. Toda vez que a inserção é chamada, se 
-- há uma colisão, então o atributo COLISÃO desta hashtable é
-- incrementado.
insert el t = undefined

-- Remove um elemento da tabela hash.
remove el t = undefined

-- Pesquisa um determinado elemento na tabela de hash. 
-- Se não estiver na tabela, retorna nulo. 
search el t = undefined

-- Pesquisa o índice de um elemento na hashtable. Retorna -1 se o 
-- elemento não está no hashtable.
indexOf el t = undefined

-- Retorna o numero de colisões que ocorreram na tabela.
getCollisions t = undefined