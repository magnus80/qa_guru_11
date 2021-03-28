package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ProjectsPage;

import static helpers.SearchItems.*;

@Tag("web")
class ProjectsPageTests extends TestBase {

    ProjectsPage projectsPage = new ProjectsPage();

    @BeforeEach
    void setUp() {
        new MainPage().openPage().openProjectsPage();
    }

    @Test
    @DisplayName("I can filter projects")
    void filteringProjects() {
        projectsPage.selectBranch(RETAIL)
                .selectClient(LEROY_MERLIN)
                .checkFoundItems(LEROY_MERLIN);
    }

    @Test
    @DisplayName("I can search projects")
    void searchingProjects() {
        projectsPage.searchItem(SIMPLE)
                .checkFoundItems(SIMPLE);
    }

}
