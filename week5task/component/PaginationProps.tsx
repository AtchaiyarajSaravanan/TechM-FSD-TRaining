import { Button, HStack } from "@chakra-ui/react";

interface PaginationProps {
  page: number;
  setPage: (page: number) => void;
}

function Pagination({ page, setPage }: PaginationProps) {
  return (
    <HStack justify="center" mt={5}>
      <Button onClick={() => setPage(page - 1)} isDisabled={page === 1}>
        Previous
      </Button>
      <Button onClick={() => setPage(page + 1)}>Next</Button>
    </HStack>
  );
}

export default Pagination;
