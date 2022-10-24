# Page_Factory_in_Selenium
Définitions:
- Page Factory est une classe fournie par Selenium WebDriver pour prendre en charge les modèles de conception d’objets de page.
- il y a deux étapes simples à travers lesquelles nous devons définir et utiliser Page Factory dans les projets Selenium:
	1- Utilisation de l’annotation @FindBy:
		- @FindBy : annotation utilisée dans Page Factory pour localiser et déclarer des éléments Web à l’aide de différents localisateurs. 
		- Vous trouverez ci-dessous un exemple de déclaration d’un élément à l’aide de @FindBy:
					-  @FindBy(id="userName") 
					-  WebElement userName;
	    - De même, on peut utiliser @FindBy avec différentes stratégies de localisation pour trouver des éléments Web et effectuer des actions sur eux.
	    - Vous trouverez ci-dessous des localisateurs qui peuvent être utilisés :
			```
			- Nom de la classe
			- .CSS
			- Nom
			- Xpath
			- TagName
			- Texte de lien
			- PartialLinkText
			
			```
	2- Initialisation des éléments à l’aide de initElements()- Il s’agit d’une méthode statique utilisée pour initialiser les éléments Web que nous localisons à l’aide du @FindBy ou d’autres annotations, instanciant ainsi la classe de page.
	        - PageFactory.initElements(WebDriver driver, java.lang.Class.pageObjectClass);

- Un autre concept intéressant proposé par Page Factory est le concept de chargement paresseux utilisant AjaxElementLocatorFactory. Il peut être utilisé lorsque votre application utilise des éléments Ajax.
- il s’agit d’une variante de Attente implicite à l’aide de la classe AjaxElementLocatorFactory. Par la suite, la syntaxe est la suivante:
		- PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
- Que sont les annotations Page Factory ?:
	 - @FindBy
	 - @FindBys :Pour localiser un élément Web avec plusieurs critères de recherche, En termes simples, @FindBys utilise plusieurs @FindBy pour chaque critère de recherche.
	 			- exemple:  
							```
							@FindBys({
									 @FindBy(class="custom-control-check-box"),
									 @FindBy(id="game-chk-box")
								})
							```
							- NB: Nous ne pouvons localiser l’élément web 'chkbox' que si les deux critères se remplissent, c’est-à-dire que la valeur de la classe est « custom-control-check-box » et la valeur id est « game-chk-box » 
	- @FindAll:  localise l’élément Web à l’aide de plusieurs critères, étant donné qu’au moins un critère correspond. Contrairement à @FindBys, il utilise une relation conditionnelle OR entre les multiples @FindBy
				- exemple:  
							```
						@FindAll({
									 @FindBy(id="btn", //doesn't match
									 @FindBy(name="sbmtBtn"), //Matches
									 @FindBy(class="btn-primary") //doesn't match
									})
							```
							- NB: L’annotation ci-dessus localiserait le bouton d’envoi même si un seul critère correspond à @FindAll fonctionne sur un ou plusieurs critères.
	- @CacheLookUp: est très utile lorsque vous faites référence au même élément Web plusieurs fois.
				- Prenons l’exemple d’une application dans laquelle chaque cas de test nécessite une opération de connexion. Dans un tel scénario, en utilisant @CacheLookUp, nous pouvons stocker les éléments Web dans la mémoire cache juste après la première lecture. Il fixe notre exécution et le code, n’a pas besoin de rechercher l’élément sur la page Web et le référence directement de mémoire.
			    - exemple:  
							```
					@CacheLookUp
							@FindBys({
							 @FindBy(class="custom-control-check-box"),
							 @FindBy(id="game-chk-box") 
							})
							``` 
	- Considérons un cas de Test simple :
		-  	Ouvrez l’URL du Site web de démonstration.
		-   Entrez le nom d’utilisateur et le mot de passe.
		-   Cliquez sur le bouton Connexion.
		-   Vérifiez le nom d’utilisateur connecté.
		-   Cliquez sur le bouton Déconnexion.
	 Pour automatiser le scénario ci-dessus en utilisant Page Factory dans Selenium
	
