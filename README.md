# AquaMobs-Crafting

AquaMobs-Crafting is a Java class designed for the AquaMobs Minecraft Server, enabling the creation of custom crafting recipes to enhance gameplay.

## Features

- Define and manage custom crafting recipes.  
- Easily integrate new items and crafting mechanics.  
- Streamline the customization process for server administrators.  

## Usage

Use the following syntax to define recipes:
```java
public class RecipeTest implements Listener {

    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent e) {

        ItemStack[] ingredients = new ItemStack[9];

        ingredients[1] = ItemStack.of(Material.DIAMOND, 3); // Slot 2's Requirement
        ingredients[4] = ItemStack.of(Material.DIAMOND, 3); // Slot 5's Requirement
        ingredients[7] = ItemStack.of(Material.DIAMOND, 3); // Slot 8's Requirement

        CustomCrafts.aquaCrafts(e, ItemStack.of(Material.DIAMOND_SWORD, 1), ingredients); // Output
    }
}
```

## Contributing

Contributions are welcome!  
Feel free to fork this repository, make your changes, and submit a pull request for review.  

## License

This project is licensed under the MIT License.  

For more information, visit the [AquaMobs-Crafting GitHub repository](https://github.com/Aquatikss/AquaMobs-Crafting).
