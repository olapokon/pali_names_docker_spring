function SearchFilter({ setSearchFilter }) {
  function handleChange(event) {
    setSearchFilter(event.target.value);
  }

  return (
    <>
      <select name="searchFilter" onChange={handleChange}>
        <option value="contains">Substring</option>
        <option value="startsWith">Starts with</option>
        <option value="endsWith">Ends with</option>
        <option value="exact">Exact match</option>
      </select>
      <style jsx>{`
        select {
          background-color: #fff;
        }

        select:focus {
          outline: none;
        }
      `}</style>
    </>
  );
}

export default SearchFilter;
