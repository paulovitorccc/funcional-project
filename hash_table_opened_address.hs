module HashTable(
  insert,
  fromList,
  isEmpty,
  size,
  search,
  indexOf,
  remove,
  getCollisions
)
where

import qualified Data.Map as Map 

hashFunction k i = mod ((mod k 619) + i) 997

hash k i map 
  | Map.member key map = hash k (i+1) map 
  | otherwise = key
  where
    key = hashFunction k i

insert [] table = table
insert (x:xs) table = Map.insert key x newTable
  where
    key = (hash x 0 newTable)
    newTable = (insert xs table)

fromList list = insert list Map.empty

isEmpty table = table == Map.empty

size table = Map.size table

search e table 
    | result == Map.empty = False
    | otherwise = True
    where
      result = Map.filter (== e) table

indexOf e table 
    | result == Map.empty = -1
    | otherwise = (Map.keys result) !! 0
    where
      result = Map.filter (== e) table

remove e table 
    | key == -1 = table
    | otherwise = Map.delete key table
    where
      key = indexOf e table
  
count k i real_key
    | key == real_key = 0
    | otherwise = 1 + count k (i + 1) real_key
    where
      key = hashFunction k i

collisions [] = 0
collisions (x:xs) = c + collisions xs
      where
        c = count (snd x) 0 (fst x)

getCollisions table = collisions (Map.toList table)
