import { useEffect, useState } from "react";
import axios from "axios";
import { Grid, GridItem, HStack } from "@chakra-ui/react";
import NavBar from "./component/NavBar";
import GameCard from "./component/GameCard";
import Sidebar from "./component/SideBar";
import Footer from "./component/Footer";
import Pagination from "./component/PaginationProps";

const API_KEY = "d72001953c644450bc56d5314b7332ee";
// Define the Game Type
interface Game {
  id: number;
  name: string;
  description_raw?: string;
  background_image: string;
}

function App() {
  const [games, setGames] = useState<Game[]>([]);
  const [page, setPage] = useState(1);

  useEffect(() => {
    axios
      .get<{ results: Game[] }>(
        `https://api.rawg.io/api/games?key=${API_KEY}&page=${page}`
      )
      .then((response) => setGames(response.data.results))
      .catch((error) => console.error("Error fetching data:", error));
  }, [page]);

  return (
    <>
      <NavBar />
      <Grid templateAreas={`"nav nav" "side main" "footer footer"`} gap={4}>
        <GridItem area={"side"} bg={"red"} p={4}>
          <Sidebar />
        </GridItem>

        <GridItem area={"main"} bg={"blue"} p={4}>
          <HStack wrap="wrap" justifyContent="center" spacing={4}>
            {games.map((game) => (
              <GameCard
                key={game.id}
                name={game.name}
                des={game.description_raw || "No description available"}
                img={game.background_image}
                alt={game.name}
              />
            ))}
          </HStack>
        </GridItem>
      </Grid>

      <Pagination page={page} setPage={setPage} />
      <Footer />
    </>
  );
}

export default App;
