(ns miraj.paper)

(alter-meta! *ns*
             (fn [m] (assoc m
                            :co-ns true
                            :resource-type :polymer
                            :resource-pfx "bower_components")))

(def pfx "bower_components")

(def components
  ;; entries:  [:fn-tag  [elt-kw elt-uri & docstring]]
  {:badge [:paper-badge "paper-badge/paper-badge.html"]
   :button [:paper-button "paper-button/paper-button.html"]
   :card [:paper-card "paper-card/paper-card.html"]
   :checkbox [:paper-checkbox "paper-checkbox/paper-checkbox.html"]
   :dialog [:paper-dialog "paper-dialog/paper-dialog.html"]
   :dialog-behavior [:paper-dialog-behavior "paper-dialog-behavior/paper-dialog-behavior.html"]
   :dialog-scrollable [:paper-dialog-scrollable "paper-dialog-scrollable/paper-dialog-scrollable.html"]
   :drawer-panel [:paper-drawer-panel "paper-drawer-panel/paper-drawer-panel.html"]
   :dropdown-menu [:paper-dropdown-menu "paper-dropdown-menu/paper-dropdown-menu.html"]
   :fab [:paper-fab "paper-fab/paper-fab.html"]
   :header-panel [:paper-header-panel "paper-header-panel/paper-header-panel.html"]
   :icon-button [:paper-icon-button "paper-icon-button/paper-icon-button.html"]
   :input [:paper-input "paper-input/paper-input.html"]
   :textarea [:paper-textarea "paper-input/paper-textarea.html"]
   :item [:paper-item "paper-item/paper-item.html"]
   :listbox [:paper-listbox "paper-listbox/paper-listbox.html"]
   :material [:paper-material "paper-material/paper-material.html"]
   :menu [:paper-menu "paper-menu/paper-menu.html"]
   :menu-shared-styles [:paper-menu-shared-styles "paper-menu/paper-menu-shared-styles.html.html"]
   :submenu [:paper-submenu "paper-menu/paper-submenu.html"]
   :menu-button [:paper-menu-button "paper-menu-button/paper-menu-button.html"]
   :menu-button-animations [:paper-menu-button-animations "paper-menu-button/paper-menu-button-animations.html"]
   :progress [:paper-progress "paper-progress/paper-progress.html"]
   :radio-button [:paper-radio-button "paper-radio-button/paper-radio-button.html"]
   :radio-group [:paper-radio-group "paper-radio-group/paper-radio-group.html"]
   :ripple [:paper-ripple "paper-ripple/paper-ripple.html"]
   :scroll-header-panel [:paper-scroll-header-panel "paper-scroll-header-panel/paper-scroll-header-panel.html"]
   :slider [:paper-slider "paper-slider/paper-slider.html"]
   :spinner [:paper-spinner "paper-spinner/paper-spinner.html"]
   :styles [:paper-styles "paper-styles/paper-styles.html"]
   :tab [:paper-tab "paper-tabs/paper-tab.html"]
   :tabs [:paper-tabs "paper-tabs/paper-tabs.html"]
   :toast [:paper-toast "paper-toast/paper-toast.html"]
   :toggle-button [:paper-toggle-button	"paper-toggle-button/paper-toggle-button.html"]
   :toolbar [:paper-toolbar "paper-toolbar/paper-toolbar.html"]
   :tooltip [:paper-tooltip "paper-tooltip/paper-tooltip"]})

#_(def polymer-paper-tags
  ; fn-tag,  elt-kw,  elt-uri,  docstring
  [['badge		:paper-badge	 	"paper-badge/paper-badge.html"
    "tag: <paper-badge>
     uri: paper-badge/paper-badge.html"]
   ['button		:paper-button		"paper-button/paper-button.html"
    "tag: <paper-button>
	uri: paper-button/paper-button.html"]
   ['card		:paper-card		"paper-card/paper-card.html"
    "tag: <paper-card>
uri: paper-card/paper-card.html docstring"]
   ['checkbox		:paper-checkbox		"paper-checkbox/paper-checkbox.html"
	"paper-checkbox/paper-checkbox.html docstring"]
   ['dialog		:paper-dialog		"paper-dialog/paper-dialog.html"
	"paper-dialog/paper-dialog.html docstring"]
   ['dialog-behavior	:paper-dialog-behavior	"paper-dialog-behavior/paper-dialog-behavior.html"
	"paper-dialog-behavior/paper-dialog-behavior.html docstring"]
   ['dialog-scrollable	:paper-dialog-scrollable "paper-dialog-scrollable/paper-dialog-scrollable.html"
	"paper-dialog-scrollable/paper-dialog-scrollable.html docstring"]
   ['drawer-panel	:paper-drawer-panel	"paper-drawer-panel/paper-drawer-panel.html"
	"paper-drawer-panel/paper-drawer-panel.html docstring"]
   ['dropdown-menu	:paper-dropdown-menu	"paper-dropdown-menu/paper-dropdown-menu.html"
	"paper-dropdown-menu/paper-dropdown-menu.html docstring"]
   ['fab		:paper-fab		"paper-fab/paper-fab.html"
	"paper-fab/paper-fab.html docstring"]
   ['header-panel	:paper-header-panel	"paper-header-panel/paper-header-panel.html"
	"paper-header-panel/paper-header-panel.html docstring"]
   ['icon-button	:paper-icon-button	"paper-icon-button/paper-icon-button.html"
	"paper-icon-button/paper-icon-button.html docstring"]
   ['input		:paper-input		"paper-input/paper-input.html"
	"paper-input/paper-input.html docstring"]
   ['textarea		:paper-textarea		"paper-input/paper-textarea.html"
	"paper-input/paper-textarea.html docstring"]
   ['item		:paper-item		"paper-item/paper-item.html"
	"paper-item/paper-item.html docstring"]
   ['listbox		:paper-listbox		"paper-listbox/paper-listbox.html"
	"paper-listbox/paper-listbox.html docstring"]
   ['material		:paper-material		"paper-material/paper-material.html"
	"paper-material/paper-material.html docstring"]
   ['menu		:paper-menu		"paper-menu/paper-menu.html"
	"paper-menu/paper-menu.html docstring"]
   ['menu-shared-styles	:paper-menu-shared-styles "paper-menu/paper-menu-shared-styles.html.html"
	"paper-menu/paper-menu-shared-styles.html.html docstring"]
   ['submenu		:paper-submenu		"paper-menu/paper-submenu.html"
	"paper-menu/paper-submenu.html docstring"]
   ['menu-button	:paper-menu-button	"paper-menu-button/paper-menu-button.html"
	"paper-menu-button/paper-menu-button.html docstring"]
   ['menu-button-animations :paper-menu-button-animations "paper-menu-button/paper-menu-button-animations.html"
	"paper-menu-button/paper-menu-button-animations.html docstring"]
   ['progress		:paper-progress		"paper-progress/paper-progress.html"
	"paper-progress/paper-progress.html docstring"]
   ['radio-button	:paper-radio-button	"paper-radio-button/paper-radio-button.html"
	"paper-radio-button/paper-radio-button.html docstring"]
   ['radio-group	:paper-radio-group	"paper-radio-group/paper-radio-group.html"
	"paper-radio-group/paper-radio-group.html docstring"]
   ['ripple		:paper-ripple		"paper-ripple/paper-ripple.html"
	"paper-ripple/paper-ripple.html docstring"]
   ['scroll-header-panel :paper-scroll-header-panel "paper-scroll-header-panel/paper-scroll-header-panel.html"
	"paper-scroll-header-panel/paper-scroll-header-panel.html docstring"]
   ['slider		:paper-slider		"paper-slider/paper-slider.html"
	"paper-slider/paper-slider.html docstring"]
   ['spinner		:paper-spinner		"paper-spinner/paper-spinner.html"
	"paper-spinner/paper-spinner.html docstring"]
   ['styles		:paper-styles		"paper-styles/paper-styles.html"
	"paper-styles/paper-styles.html docstring"]
   ['tab		:paper-tab		"paper-tabs/paper-tab.html"
	"paper-tabs/paper-tab.html docstring"]
   ['tabs		:paper-tabs		"paper-tabs/paper-tabs.html"
	"paper-tabs/paper-tabs.html docstring"]
   ['toast		:paper-toast		"paper-toast/paper-toast.html"
	"paper-toast/paper-toast.html docstring"]
   ['toggle-button	:paper-toggle-button	"paper-toggle-button/paper-toggle-button.html"
	"paper-toggle-button/paper-toggle-button.html docstring"]
   ['toolbar		:paper-toolbar		"paper-toolbar/paper-toolbar.html"
	"paper-toolbar/paper-toolbar.html docstring"]
   ['tooltip		:paper-tooltip		"paper-tooltip/paper-tooltip"
    "paper-tooltip/paper-tooltip"]])

#_(make-resource-fns :html polymer-paper-tags)

