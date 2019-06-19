module HashTableTest where

import Test.HUnit
import HashTable as HashTable
import Data.Map as Map

hs = HashTable.fromList [300, 919, 1538, 2157, 2776, 3395, 4014, 4633, 5252, 5871, 6490, 7109]
conflitInsert1 = TestCase (assertEqual "tic1" "300" (hs Map.! 300))
conflitInsert2 = TestCase (assertEqual "tic2" "919" (hs Map.! 301))
conflitInsert3 = TestCase (assertEqual "tic3" "1538" (hs Map.! 302))
conflitInsert4 = TestCase (assertEqual "tic4" "2157" (hs Map.! 303))
conflitInsert5 = TestCase (assertEqual "tic5" "2776" (hs Map.! 304))
conflitInsert6 = TestCase (assertEqual "tic6" "3395" (hs Map.! 305))
conflitInsert7 = TestCase (assertEqual "tic7" "4014" (hs Map.! 306))
conflitInsert8 = TestCase (assertEqual "tic8" "4633" (hs Map.! 307))
conflitInsert9 = TestCase (assertEqual "tic9" "5252" (hs Map.! 308))
conflitInsert10 = TestCase (assertEqual "tic10" "5871" (hs Map.! 309))
conflitInsert11 = TestCase (assertEqual "tic11" "6490" (hs Map.! 310))
conflitInsert12 = TestCase (assertEqual "tic12" "7109" (hs Map.! 311))
conflictInsertTests = TestList [conflitInsert1, conflitInsert2, conflitInsert3, conflitInsert4, conflitInsert5, conflitInsert6, conflitInsert7, conflitInsert8, conflitInsert9, conflitInsert10, conflitInsert11, conflitInsert12] 

------------------------------------------





tLabelInsert1 = TestLabel "Teste: Insert valores que geram conflito" conflictInsertTests

testAll = TestList [tLabelInsert1]