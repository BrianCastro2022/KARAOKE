@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogotá - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n9_karaoke
REM Autor: Equipo Cupi2  2018-2
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
java -ea -classpath lib/karaoke.jar;test/lib/karaokeTest.jar;test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.karaoke.test.KaraokeTest
java -ea -classpath lib/karaoke.jar;test/lib/karaokeTest.jar;test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.karaoke.test.CategoriaTest
java -ea -classpath lib/karaoke.jar;test/lib/karaokeTest.jar;test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.karaoke.test.ArtistaTest
java -ea -classpath lib/karaoke.jar;test/lib/karaokeTest.jar;test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.karaoke.test.CancionTest
cd bin/win