mkdir -p ./target/CoffeeMaker_Web/WEB-INF/classes/
#touch ./../../.gitignore
#echo "./mp1/CoffeeMaker_Web/target/" > ./../../.gitignore
javac -classpath "./src/main/java" ./src/main/java/edu/ncsu/csc326/coffeemaker/*.java


#1.c
mkdir -p ./target/CoffeeMaker_Web/WEB-INF/classes/edu/ncsu/csc326/coffeemaker/exceptions/

for i in ./src/main/java/edu/ncsu/csc326/coffeemaker/*.class
do
	cp -v "$i" ./target/CoffeeMaker_Web/WEB-INF/classes/edu/ncsu/csc326/coffeemaker/
done

for i in ./src/main/java/edu/ncsu/csc326/coffeemaker/exceptions/*.class
do
	cp "$i" ./target/CoffeeMaker_Web/WEB-INF/classes/edu/ncsu/csc326/coffeemaker/exceptions/
done

# 2.a
for i in ./src/main/webapp/*.jsp
do
	cp "$i" ./target/CoffeeMaker_Web/
done

#2.b
cp ./src/main/webapp/WEB-INF/web.xml ./target/CoffeeMaker_Web/WEB-INF

cd target/CoffeeMaker_Web
jar -cvf ../CoffeeMaker_Web.war *
